<script setup>
import { decodeCredential } from 'vue3-google-login';

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
</script>

<template>
  <main>
    <section>
      <h1>로그인 페이지</h1>
      <div>
        <a href="">구글 로그인</a>
      </div>
      <div>
        <GoogleLogin :callback="callback"/>
      </div>
    </section>
  </main>
</template>
