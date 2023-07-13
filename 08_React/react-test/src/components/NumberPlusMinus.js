import React, {useState} from 'react'



const NumberPlusMinus = () => {

    let [count, setCount] = useState(0);

    const plus = () => {
        setCount(() => count + 1 );
    }

    const minus = () => {
        setCount(() => count - 1 );
    }

    return(
        <>
        <button onClick={minus} className='minus'>-</button>
        {count}
        <button onClick={plus} className='plus'>+</button>
        </>
    );
}

export default NumberPlusMinus;