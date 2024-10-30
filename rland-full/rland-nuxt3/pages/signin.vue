<script setup>

const callback = (response) => {
  // This callback will be triggered when the user selects or login to
  // his Google account from the popup
  console.log("Handle the response", response);
};
</script>

<template>
  <main>
    <div>
      <GoogleLogin :callback="callback" />
    </div>
  </main>
</template>

<style>
</style>