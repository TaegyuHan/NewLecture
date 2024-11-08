export default defineNuxtRouteMiddleware((to, from) => {
    // to.path

    // 1. 너 누구야? 인증정보 줘봐
    //      1-1. 안 가지고 왔는디요? -> 가지고와 /signin으로 보내기
    //      1-2. 가지고 왔는디요? -> 일단 다음 2단계로 진행
    if (to.path.startsWith('/admin')) {
        // 인증정보를 갖고 있지 않다면?
        if (useUserDetails().isAnonymous()) {
            return navigateTo(`/signin?returnURL=${to.fullPath}`);
        }

        // 너 이런 인증 정보도 가지고 있어?
        if (useUserDetails().hasRole('ROLE_ADMIN')) {
            return;
        }
    }

    // 2. /admin/** 이 목적이라면 너 관리자야?
    //      2-1. 예 -> 보내기
    //      2-2. 아니오 -> 403에러

    console.log('to:', to);
    console.log('from:', from);
});