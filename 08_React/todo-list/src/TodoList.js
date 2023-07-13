import React, {useState, useContext} from 'react'
import { TodoListContext } from './App'

const TodoList = () => {
    const { todoList, setTodoList, loginMember } = useContext(TodoListContext);
    const [inputTodo, setInputTodo] = useState('');

    let keyIndex = 0;
    // 할 일 추가
    const handleAddTodo = () => {
        if(inputTodo.trim().length === 0) {
            alert("할 일을 입력해 주시기 바랍니다.")
            return;
        }
        fetch("/todo", {
            method : 'post',
            headers : {'Content-Type' : 'application/json'}, // 돌아오는 타입이 text면 아무것도 안 적어도 됨
            body : JSON.stringify({
                title : inputTodo,
                todoMemberNo : loginMember.todoMemberNo
            })
        })
        .then(resp => resp.text())
        .then(todoNo => {
            if(Number(todoNo) === 0) { // 실패 시 멈춤(ex. DB에 트레픽이 너무 많이 몰려서 시간초과로 멈추는 경우)
                            // todoNo는 String타입이라 Number타입으로 파싱이 필요(react에선 '==='를 권장하기 때문에 데이터 파싱을 하는게 좋다)
                return;
            }

            // 기존 todoList + 새로 추가된 Todo를 이용해 새배열을 만들어 todoList에 대입
            // 새로 추가된 Todo 만들기
            const newTodo = {
                todoNo : todoNo,
                title : inputTodo,
                isDone : 'X',
                todoMemberNo : loginMember.todoMemberNo
            };

            // 기존 todoList + newTodo를 이용해 새 배열 만들기
            const newTodoList = [...todoList, newTodo];
            // [...] 전개연산자 : 배열의 가장 바깥쪽 괄호를 지워줌
            
            // todoList에 대입
            setTodoList(newTodoList)
            setInputTodo('');

        })
        .catch(e => console.log(e));
    }


    // o,x 업데이트
    const handleToggleTodo = (todo, index) => {
   /*      console.log(todo);
        console.log(index); */

        fetch('/todo', {
            method : 'put',
            headers : {'Content-Type' : 'application/json'},
            body : JSON.stringify({
                todoNo : todo.todoNo,
                isDone : todo.isDone === '0' ? 'X' : 'O'
            })
        })
        .then(resp => resp.text())
        .then(result => {
            if(result === '0') { // 이번엔 숫자 0을 String으로 바꿔보기
                console.log('업데이트 실패');
                return;
            }

            // 수정 성공 시 todoList 값을 변경해서 리랜더링(state값이 바뀌면 알아서 리랜더링이 되는걸 이용해)
            // todoList를 깊은 복사(똑같은 배열을 하나 더 만듦)
            const newTodoList = [...todoList];
            newTodoList[index].isDone =  newTodoList[index].isDone  === 'O' ? 'X' : 'O';

            setTodoList(newTodoList)
        })
        .catch(e => console.log(e));

    }

    // 삭제
    const handleDeleteTodo = (todoNo, index) => {
        fetch('/todo', {
            method : 'delete',
            headers : {'Content-Type' : 'application/json'},
            body : todoNo
        })
        .then(resp => resp.text())
        .then(result => {
            if(result === '0') {
                console.log('삭제 실패');
                return;
            }

            const newTodoList = [...todoList]; // 배열 깊은 복사

            // 배열.splice (인덱스, 몇칸) : 배열의 인덱스번째 요소 부터 몇 칸을 잘라내서 반환할지 지정(배열에서 잘라낼 부분을 선택하는 것)
            newTodoList.splice(index, 1) // index번째만 삭제
            setTodoList(newTodoList); // 리랜더링
        })
        .catch(e => console.log(e));
    }


    return(
        <>
            {/* <h1>{loginMember.name}의 To Do List</h1> */}
            <h1>{loginMember.name}의 To Do List</h1>
            <div className="todo-container">
            <h3>할 일(Todo) 입력</h3>
            <div>
                <input type="text" value={inputTodo} onChange={e => setInputTodo(e.target.value)}/>
                <button onClick={handleAddTodo}>Todo 추가</button>
            </div>

            <ul>
                {/* 배열.map : 기존 배열을 이용해 새로운 배열을 만드는 것 */}
                {todoList.map((todo, index) => ( // 여기서 'todo'는 todoList속 하나인 'todo', index는 몇번째 todo인지 알려주는 index (버튼을 누르면 그에 해당되는 todo에 대한 정보, 그 todo가 todoList에서 몇 번째 있는지 알려줌)
                    <li key={keyIndex++}>
                        <div>
                            <span className={todo.isDone === 'O' ? 'todo-compleate' : ''}> {todo.title} </span>

                            <span>
                                <button onClick={() => { handleToggleTodo(todo, index) }}>{todo.isDone}</button>
                                <button onClick={() => { handleDeleteTodo(todo.todoNo, index) }}>삭제</button>
                            </span>
                        </div>
                    </li>
                ))} 
            </ul>

            </div>
        </>
    );


}

export default TodoList;
