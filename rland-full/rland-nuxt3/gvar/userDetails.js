const state = reactive({
    username: null,
    email: null,
    roles: []
});

const actions = {
    login(username, email, roles) {
        state.username = username;
        state.email = email;
        state.roles = roles;
    },
    logout() {
        state.username = null;
        state.email = null;
        state.roles = [];
    },
    isAnonymous() {
        return state.username === null;
    }
};

export default state;
export { actions };