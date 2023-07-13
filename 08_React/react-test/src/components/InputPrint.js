import React, {useState} from 'react';

/* state 두 개 필요 */

const InputPrint = () => {

  const [inputMessage, setInputMessage] = useState();
  const [message, setMessage] = useState();

  const sendMessage = (e) => {
    setMessage(inputMessage)
  }
  
  const changeInputMessage = (e) => {
    setInputMessage(e.target.value);
  }

  
  return(
    <>
    <input type='text' onChange={changeInputMessage}/>
    <button onClick={sendMessage}>보내기</button>
    <div>
      <h2>
        {message}
      </h2>
    </div>
    </>
  )

}

export default InputPrint;