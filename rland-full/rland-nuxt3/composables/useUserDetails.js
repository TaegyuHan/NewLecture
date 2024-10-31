export default () => {

    const id = useState('id', () => null);
    const username = useState('username', () => null);
    const email = useState('email', () => null);
    const roles = useState('roles', () => []);

    const isAnonymous = () => {
        return username === null;
    };

    const login = (loginInfo) => {
        id.value = loginInfo.id;
        username.value = loginInfo.username;
        email.value = loginInfo.email;
        roles.value = loginInfo.roles;
    };

    const logout = () => {
        id.value = null;
        username.value = null;
        email.value = null;
        roles.value = [];
    }

    return {
        id,
        username,
        email,
        roles,
        isAnonymous,
        login,
        logout
    }
};