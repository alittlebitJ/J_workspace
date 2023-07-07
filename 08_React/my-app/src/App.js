import './App.css';
// components 폴더의 Exam1.js를 가져와서 사용하겠다
// 사용할 때의 이름을 EX1으로 지정
import Ex1 from './components/Exam1';
import Ex2 from './components/Exam2';
import PropsEX from './components/R01_props';
import State1 from './components/R02_state1';
import State2 from './components/R03_state2';
import State3 from './components/R04_state3';
import TodoList1 from './components/R05_todolist1';
import ContextApi from './components/R06_context_api';


function App() {
  // 리액트의 컴포넌트는 딱 하나의 요소만을 반환할 수 있다 -> 여러 요소를 반환하고 싶을 때는 부모 요소로 묶어준다
  return (
    /* fragment (<> </>) : 반환되는 요소를 감쌀 때 사용, 해석 안 됨 */
    <>  
      {/* 이게 jsx 주석 */}
      <h1>hello react</h1>
      <div>안되던디</div>
      {/* <Ex1/> */} {/* 이러한 단위 하나 하나를 컴포넌트라고 부른다 */}
      {/* <Ex2/> */}
      {/* <PropsEX name={'홍길동'} /> */}
      {/* <PropsEX name={'김길동'} /> */}
      {/* <PropsEX name={'박공부'} /> */}
      

      {/* R02_state1 */}
      {/* <State1/> */}
      {/* <State2 init={100} /> */}
      {/* <State3/> */}
      {/* R05_TodoList1 */}
      {/* <TodoList1/> */}
      <ContextApi/>
    </>
  );
}

export default App;
