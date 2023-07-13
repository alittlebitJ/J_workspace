import './App.css';
import React, { useState, createContext } from 'react';
import SignupContainer from './Signup';
import Login from './Login';
import TodoList from './TodoList';


export const TodoListContext = createContext(); // 전역변수 생성

function App() {
  // 회원가입, 로그인, 회원의 To do List 출력/추가/제거
  const [signupView, setSignupView] = useState(false);
  // 로그인한 회원 정보 저장
  const [loginMember, setLoginMember] = useState(null);
  // 로그인한 회원의 todo-list를 저장
  const [todoList, setTodoList] = useState([]);

  return (
    <TodoListContext.Provider value={ { todoList, setTodoList, setLoginMember, loginMember} }>                        
                                          {/* click시 fals/true toggle */}
      <button onClick={() => {setSignupView(!signupView)}}>
        {signupView ? ('회원 가입 닫기') : ('회원 가입 열기')}
      </button>

      <div className='signup-wrapper'>
        {/* signupView가 true인 경우에만 회원 가입 컴포넌트 랜더링 */}
        {/* 조건식 && (true인 경우 작성할 코드) */}
        {signupView === true && (<SignupContainer/>)}
      </div>

      <h1>Todo List</h1>
      <Login/>

      <hr/>
      {/* 로그인이 되어 있을 때에만 출력 */}
      {loginMember&&(<TodoList />)} 
    </TodoListContext.Provider>
  );
}

export default App;
