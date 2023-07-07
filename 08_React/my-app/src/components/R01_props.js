import React  from "react";

// props : 부모 컴포넌트가 자식 컴포넌트에게 데이터 전달 시 사용하는 객체
// *** props는 자식 -> 부모 데이터 전달 불가능. 오직 부모에서 자식으로 일방통행

const ChildComponent = (props) => {
  return(
    <>
      <ul>
        <li>이름 : {props.name}</li>
        <li>나이 : {props.age}</li>
      </ul>
    </>
  );
};

const MenuPrint = (props) => {
  return (
    <>
      <h4>김밥 : {props.김밥}, 떡볶이 : {props.떡볶이}</h4>
    </>
  )
};

// 함수를 변수처럼 작성하는 경우가 훨씬 많다고 함
const PropsEX = (props) => {
  // props 매개변수 : 부모로 부터 전달받은 값이 담겨있는 객체
  console.log(props)
  console.log(props.name)
  const menu = {'김밥':3000, '떡볶이':4000};
  return (
    <>
      <h1>{props.name}</h1>
      <ChildComponent name={props.name} age={props.name === '홍길동' ? 20 : 25}/>
      <MenuPrint {...menu} />
    </>
  );
}
export default PropsEX;
