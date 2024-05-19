new Vue({
    el: '#registry',
    data: {
        email: '',
        password: '',
        verificationCode: '',
        isSendingCode: false // 标记以在code发送期间禁用按钮
    },
    methods: {
        sendCode() {
            axios.post('http://122.51.59.201:8012/api/sendcode', {email: this.email})
                .then(response => {
                    if (response.data.code === 1) {
                        alert('验证码已发送至您的邮箱');
                        this.isSendingCode = true;
                        setTimeout(() => {
                            this.isSendingCode = false;
                        }, 3000);
                    } else {
                        alert('发送验证码失败: ' + response.data.msg);
                    }

                })
                .catch(error => {
                    alert('发送验证码失败！');
                });
        },
        register() {
            // Send registration data to '/api/register'
            axios.post('http://122.51.59.201:8012/api/register', {
                email: this.email,
                password: this.password,
                verificationCode: this.verificationCode
            })
                .then(response => {
                    // 判断返回的编码
                    if (response.data.code === 1) {
                        // 注册成功
                        alert('注册成功！');
                        window.location.href = './index.html';
                    } else {
                        // 注册失败，显示错误信息
                        alert('注册失败: ' + response.data.msg);
                    }
                })
                .catch(error => {
                    // 捕获并显示网络请求失败的情况
                    alert('注册失败: 网络请求错误');
                });
        }
    }
});