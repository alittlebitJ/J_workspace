import React, { useState } from "react";

/* 컴포넌트 이름을 나타내는 함수는 대문자여야 */
/* 리액트는 컴포넌트의 상태가 변할 때 마다 리랜더링을 수용 */
const InputTest = () => {
    /*        변수      함수(setter 역할)         */
    const [inputValue, setInputValue] = useState("초기값");
    // inputValue : 값을 저장하는 변수
    // setInputValue : inputValue에 값을 대입하는 setter 역할의 함수


    const changeInputValue = (e) => {
        console.log(e.target.value)
        setInputValue(e.target.value)
    };

    return (
        <>  {/* 첫 랜더링 : value = "초기값" -> input의 값을 변경 (컴포넌트의 상태 변화 -> 리랜더링 진행) */}"
            {/* + 1)onChange (값이 변했을 때) -> changmeinputValue 함수가 실행되면서 inputValue에 e.target.value (변화된 값을 대입) */}
            {/* 2) 컴포넌트의 상태 변화 -> 리랜더링 진행 */}
            {/* 리랜더링 -> value = 변경된 inputValue의 값 */}
            <input type = "text" value={inputValue}
            onChange={changeInputValue}
            /* value={inputValue} onChange={(e) => {setInputValue(e.target.value)}}  */
            />
        </>
    );
};

export default InputTest;