export function useAuthFetch(url, options={}) {
    const { token } = useUserDetails();

    console.log(token.value);
    options.headers = {
        ...options.headers,
        ...(token.value && { Authorization: `Bearer ${token.value}` })
    };

    console.log('header', options.header);
    const config = useRuntimeConfig();
    console.log(`${config.public.apiBase}${url}`);
    return $fetch(`${config.public.apiBase}${url}`, options);
}