
new Vue({
    el: '#login',
    data: {
        email: '',
        password: ''
    },
    methods: {
        login() {
            axios.post('http://122.51.59.201:8012/api/login', {email: this.email, password: this.password})
                .then(response => {
                    if (response.data.code === 1) {
                        alert('登录成功!');
                        // 登录成功跳转到xxx页面
                        window.location.href = 'https://www.baidu.com/index.html';
                    } else {
                        alert('登录失败: ' + response.data.msg);
                    }
                })
                .catch(error => {
                    alert('登录失败: 网络请求错误');
                });
        }
    }
});
