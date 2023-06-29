import React, {Component} from 'react' ;
// node-moduls 폴더에 있는 react 패키지를 가져옴

// 클래스형 컴포넌트 만들기
// 1. Component 상속 받기
// 2. render() 함수 작성하기(필수)
// 3. 만든 class를 export defaul로 지정하기
class Exam1 extends Component {
  constructor(props) {
    super(props);
    this.state = {count : 0};
    // thist.state 상태변수
  }

  handleClick = () => {
    this.setState({ count: this.state.count + 1 });
    }
  
  // 화면 랜더링 시 render() 함수에서 반환된 값이 화면에 출력
  render() { // 랜더링 될 때 이걸 실행해라
    return ( 
      <>
          <h2>클래스형 컴포넌트</h2>
          <h1>Count : {this.state.count}</h1>
          <button onClick={this.handleClick}>Increment</button>
          {/* react에서는 카멜로 씀 'onClick' */}
      </>
    );
  }
}

export default Exam1;