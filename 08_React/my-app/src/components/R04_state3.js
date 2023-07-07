import React, { useState } from "react"

const Id = ({handler}) => {

//    console.log(handler) // props로 전달한 값중 key가 handler인 요소의 value값 반환
    // console.log(props.handler)

    return (
        <>  {/*요소.classList.add 와 유사 */}
            <div className="wrapper">
                <label htmlFor="id">ID : </label>
                <input type="text" id="id" onChange={handler}/>
            </div>

        </>
    )
};

const Pw = ({handler}) => {
    return (
        <>  {/*요소.classList.add 와 유사 */}
            <div className="wrapper">
                <label htmlFor="Pw">Password: </label>
                <input type="password" id="pw" onChange={handler}/>
            </div>
        </>
    )
};

// 상태 끌어 올리기
const StateLiftingUp = () => {

    const [id, setId] = useState("");
    const [pw, setPw] = useState("");
    const idHandler = (e) => { // id값 변경 함수
        setId(e.target.value)
    };
    const pwHandler = (e) => { // pw값 변경 함수
        setPw(e.target.value)
    };


    console.log("id : " + id);
    console.log("pw : " + pw);

    return (
        <>
            <Id handler = {idHandler}/>
            <Pw handlwer = {pwHandler}/>
            <div>
                <button disabled={id.length === 0 || pw.length == 0}>Login</button>
            </div>
        </>
    )
}
    ;

export default StateLiftingUp;