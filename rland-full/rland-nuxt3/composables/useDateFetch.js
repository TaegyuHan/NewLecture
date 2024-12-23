export function useDataFetch(url, options={}) {

    const { token } = useUserDetails();

    options.header = {
        ...options.headers,
        ...(token.value && { Authorization: `Bearer ${token.value}` })
    };

    // JWT 권한을 부여받으려면 Header
    // SSR userFetch 사용
    // CSR $fetch() 사용

    const config = useRuntimeConfig();
    return $fetch(`${config.public.apiBase}${url}`, options);
}