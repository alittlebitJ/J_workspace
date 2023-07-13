import React, { useState, useContext } from 'react';
import { TodoListContext } from './App'; // App.js에서 TodoListContext라는 전역변수를 가져다 사용하겠다

const LoginComponent = () => {
    // 전역변수 Context를 사용
    const { setTodoList, setLoginMember, loginMember } = useContext(TodoListContext);
    const [id, setId] = useState('');
    const [pw, setPw] = useState('');

    const login = () => {
        fetch('/login', {
            method : 'post',
            headers : {
                'Content-Type' : 'application/json', // 전달되는 데이터 타입
                'Accept' : 'application/json'        // 돌아오는 응답 데이터 타입
            },
            body : JSON.stringify({
                id : id,
                pw : pw
            })
        })
        .then(resp => resp.json())
        .then(map => {
            console.log(map);
            // 로그인 실패시
            if(map.loginMember === null) {
                alert('아이디 또는 비밀번호가 일치하지 않습니다');
                return;
            } 

            // 로그인 성공시
            setLoginMember(map.loginMember);
            setTodoList(map.todoList);

            setId('');
            setPw('');
        })
    };
    const logout = () => {
        setLoginMember(null);
    };

    return(
        <div className="login-container">
        <table>
            <tbody>
                <tr>
                    <th>ID</th>
                    <td>
                        <input type="text" onChange={e => setId(e.target.value)} value={id} />
                    </td>
                </tr>

                <tr>
                    <th>PW</th>
                    <td>
                        <input type="password" onChange={e => setPw(e.target.value)} value={pw} />
                    </td>
                    <td>
                        <button onClick={login} >Login</button>
                    </td>
                </tr>
            </tbody>
        </table>
            {loginMember && ( // && : 왼쪽에 있는게 참이라면(로그인 멤버가 있다면)
                <button onClick={logout}>로그아웃</button>
            )}
        </div>
    );
};

export default LoginComponent;
