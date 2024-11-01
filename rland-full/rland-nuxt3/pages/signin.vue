<script setup>
import {decodeCredential, googleTokenLogin} from 'vue3-google-login';

const callback = (response) => {
  let user = decodeCredential(response.credential);

  const userDetails = useUserDetails();
  console.log('signin', userDetails);

  // 객체 형태로 로그인 정보 전달
  userDetails.login({
    id: 1,
    username: user.username,
    email: user.email,
    roles: ['member', 'admin']
  });

  console.log(userDetails.username.value, userDetails.email.value);

  const returnURL = useRoute().query.returnURL || "/";
  return navigateTo(returnURL);
};

const googleLoginHandler = async () => {

  let token;
  {
    let response = await googleTokenLogin();
    console.log('googleLoginHandler', response);
    token = response.access_token;
  }

  {
    let userInfo = await fetch(`https://www.googleapis.com/oauth2/v3/userinfo?access_token=${token}`);
    let userInfoJson = await userInfo.json();
    console.log('userInfo', userInfo);
  }
};

</script>

<template>
  <main>
    <section>
      <h1>로그인 페이지</h1>
      <form>
        <div>
          <div>
            <label>
              사용자 아이디:
              <input type="text" />
            </label>
          </div>
          <div>
            <label>
              비밀번호:
              <input type="text" />
            </label>
          </div>
          <div>
            <input type="submit" value="로그인" />
          </div>
          <div>
            <a @click.prevent="googleLoginHandler" class="n-btn n-btn-color:main">구글 로그인</a>
          </div>
        </div>
        <div>
          <a href="">구글 로그인</a>
        </div>
        <div>
          <GoogleLogin :callback="callback"/>
        </div>
      </form>
    </section>
  </main>
</template>
