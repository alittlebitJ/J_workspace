import './App.css';
import React, { useState, createContext } from 'react';
import SignupContainer from './Signup';

// 회원가입, 로그인, 회원의 To do List 출력/추가/제거
function App() {
  const [signupView, setSignupView] = useState(false);

  return (
    <>                        {/* click시 fals/true toggle */}
      <button onClick={() => {setSignupView(!signupView)}}>
        {signupView ? ('회원 가입 닫기') : ('회원 가입 열기')}
      </button>

      <div className='signup-wrapper'>
        {/* signupView가 true인 경우에만 회원 가입 컴포넌트 랜더링 */}
        {/* 조건식 && (true인 경우 작성할 코드) */}
        {signupView === true && (<SignupContainer/>)}
      </div>
    </>
  );
}

export default App;
