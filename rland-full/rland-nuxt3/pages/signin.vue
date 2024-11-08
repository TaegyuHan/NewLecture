<script setup>
import { decodeCredential, googleTokenLogin } from 'vue3-google-login';
import { jwtDecode } from "jwt-decode";
import {useRoute} from "vue-router";

const userDetails = useUserDetails();
let route = useRoute();

// --- reactive variables -------------------------------------------------- //
const username = ref('');
const password = ref('');

// --- API call functions -------------------------------------------------- //


// --- callback function ---------------------------------------------------- //
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

  console.log(query);
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

const localLoginHandler = async () => {
  console.log('localLoginHandler');

  // Restful 형태가 있다.
  let idToken = await useDataFetch("/auth/signin", {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: {
      username: username.value,
      password: password.value
    }
  });

  let userInfo = jwtDecode(idToken.token);
  userDetails.setAuthentication({
    id:userInfo.id,
    username: userInfo.username,
    email: userInfo.email,
    roles: userInfo.roles.map(role => role.authority),
    token: idToken.token
  });

  console.log(userInfo);
  // 서버로 인증정보를 제공하면서 인증을 요청

  // 인증 서버 = 리소스 서버 이기 때문에 id_token을 발급 받아서 처리한다.

  // 앞에서 받은 사용자정보를 이용해서 상태 저장을 한다.
  // console.log(userDetails.username.value, userDetails.email.value);
  const returnURL = route.query.returnURL || "/";
  console.log("returnURL", returnURL);
  return navigateTo(returnURL);

  // 사용자에 따른 페이지로 이동
};
</script>

<template>
  <main>
    <section>
      <h1>로그인 페이지</h1>
      <form @submit.prevent="localLoginHandler">
        <div>
          <div>
            <label>
              사용자 아이디:
              <input type="text" v-model="username" placeholder="아이디를 입력하세요" />
            </label>
          </div>
          <div>
            <label>
              비밀번호:
              <input type="text" v-model="password" required />
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