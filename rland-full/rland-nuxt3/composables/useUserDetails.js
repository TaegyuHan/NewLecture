export default () => {

    const id = useState('id', () => null);
    const username = useState('username', () => null);
    const email = useState('email', () => null);
    const roles = useState('roles', () => []);
    const token = useState('token', () => "");

    const isAnonymous = () => {
        return username.value === null;
    };

    const setAuthentication = (loginInfo) => {
        id.value = loginInfo.id;
        username.value = loginInfo.username;
        email.value = loginInfo.email;
        roles.value = loginInfo.roles;
        token.value = loginInfo.token;

        if (!import.meta.env.SSR) {
            localStorage.setItem('id', loginInfo.id); // 서버에는 로컬 스토리지가 없다.
            localStorage.setItem('username', loginInfo.username);
            localStorage.setItem('email', loginInfo.email);
            localStorage.setItem('roles', JSON.stringify(loginInfo.roles)); // [] -> "[]"
            localStorage.setItem('token', loginInfo.token);
        }
    };

    const loadUserFormStorage = () => {
        if (!import.meta.env.SSR) {

            if (!localStorage.getItem("username")) {
                return;
            }

            id.value = localStorage.getItem('id');
            username.value = localStorage.getItem('username');
            email.value = localStorage.getItem('email');
            roles.value = JSON.parse(localStorage.getItem('roles'));
            token.value = localStorage.getItem('token');
        }
    };

    const logout = () => {
        id.value = null;
        username.value = null;
        email.value = null;
        roles.value = [];
        token.value = null;
    };

    const hasRole = (role) => {
        return roles.value.includes(role);
    };

    return {
        id,
        username,
        email,
        roles,
        token,
        hasRole,
        isAnonymous,
        setAuthentication,
        loadUserFormStorage,
        logout
    };
};