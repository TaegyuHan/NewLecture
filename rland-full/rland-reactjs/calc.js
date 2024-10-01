// JSX을 사용해서 화면을 보여준다.
// html로 랜더링을 babel이 해준다.
class Calc extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
        x: 0,
        y: 0,
        result: 0
    };
  }

  calcHandler(e) {
    e.preventDefault();
    const x = parseInt(this.state.x);
    const y = parseInt(this.state.y);
    this.setState({ result: x + y });
  }

  xInputHandler = (e) => {
    this.setState({ x: e.target.value });
  };

  yInputHandler(e) {
    this.setState({ y: parseInt(e.target.value) });
  }

  render() {
    return (
      <div>
        <section id="calc" className="n-frame:rounded-shadow w:2/3">
          <h1>계산기</h1>
          <form className="n-form">
            <div>
              <label>
                <span>X:</span>
                <input type="text" value={this.state.x} onChange={(e) => {this.setState({ x: parseInt(e.target.value) })}} dir="rtl" />
              </label>
            </div>
            <div>
              <label>
                <span>Y:</span>
                <input type="text" value={this.state.y} onChange={this.yInputHandler.bind(this)} dir="rtl" />
              </label>
            </div>
            <div>
              <input
                onClick={ (e) => {
                    e.preventDefault();
                    const x = this.state.x;
                    const y = this.state.y;
                    this.setState({ result: x + y });
                }}
                className="n-btn n-btn-color:main"
                type="submit"
                value="계산하기"
              />
            </div>
            <div>
              <label>
                <span>Result:</span>
                <input type="text" readOnly value={this.state.result} dir="rtl" />
              </label>
            </div>
          </form>
        </section>
      </div>
    );
  }
}

ReactDOM.render(<Calc />, document.getElementById("root"));
