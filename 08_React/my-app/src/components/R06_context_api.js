import React, { useContext, useState, userContext } from 'react';
/* 단축키 imrs */
import UserContext from '../contexts/UserContext';




// 개인 정보를 출력하기 위한 자식 컴포넌트
const User = () => {
    // useContext(Context명)  : 지정된 Context를 사용하겠다 -> 부모 컴포넌트에서 제공한 값을 꺼낼 수 있다
    const {user, temp} = useContext(UserContext);
    // UserContext(user, temp)에서 user를 꺼내서 변수 user에 저장
    // UserContext(user, temp)에서 temp를 꺼내서 변수 temp에 저장

    return(
        <ul>
            <li>{user.name}</li>
            <li>{user.email}</li>
        </ul>
    );
};

const Profile = () => {
    const [user, setUser] = useState(null);
    const print = () => {
        setUser({name:'김미영', email:'my-kim@kh.or.kr'});
    };
    const temp = '임시 변수';

    return(
        /* 
        UserContext가 감싸고 있는 자식 컴포넌트에게
        Context API를 이용해서 user를 제공
         */
        <UserContext.Provider value={{user, temp}}> {/* 태그x UserContext가 감싸고 있는 안에서 UserContext를 사용하겠다 */}
            <div>
                {/* 삼항 연산자를 이용한 컴포넌트 랜더링 제어(조건부 랜더링) */}
                {/* { 조건식 ? () : () } */}
                { user != null ? (
                    <>
                        <User/>
                        <button onClick={() => {setUser(null)}}>개인 정보 숨기기</button>
                    </>
                ) : (
                    <button onClick={print}>개인 정보 출력</button>
                ) }

            </div>
        </UserContext.Provider>
    );
};



export default Profile;