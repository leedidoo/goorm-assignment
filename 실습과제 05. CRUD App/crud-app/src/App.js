import React, { Component } from "react";
import "./App.css";

export default class App extends Component {
  state = {
    expenseData: [],
    value: "",
    amount: "",
    editingId: null,
  };

  handleRemove = (id) => {
    let newExpenseData = this.state.expenseData.filter(
      (data) => data.id !== id
    );
    console.log("newExpenseData", newExpenseData);
    this.setState({ expenseData: newExpenseData });
  };

  handleSubmit = (e) => {
    e.preventDefault();

    if (this.state.editingId !== null) {
      const updatedExpenseData = this.state.expenseData.map((data) =>
        data.id === this.state.editingId
          ? { ...data, title: this.state.value, amount: this.state.amount }
          : data
      );

      this.setState({
        expenseData: updatedExpenseData,
        value: "",
        amount: "",
        editingId: null,
      });
    } else {
      let newExpense = {
        id: Date.now(),
        title: this.state.value,
        amount: this.state.amount,
      };

      this.setState({
        expenseData: [...this.state.expenseData, newExpense],
        value: "",
        amount: "",
      });
    }
  };

  handleEdit = (id, title, amount) => {
    this.setState({
      value: title,
      amount: amount,
      editingId: id,
    });
  };
  getTotalExpense = () => {
    // 총 지출 금액 계산
    return this.state.expenseData.reduce(
      (total, data) => total + parseInt(data.amount, 10),
      0
    );
  };

  render() {
    return (
      <div className="container">
        <h1>예산 계산기</h1>
        <div className="expenseForm">
          <form>
            <div className="form-center">
              <div className="form-group">
                <label htmlFor="charge">지출항목</label>
                <input
                  type="text"
                  className="form-control"
                  id="charge"
                  name="charge"
                  placeholder="예) 렌트비"
                  value={this.state.value}
                  onChange={(e) => this.setState({ value: e.target.value })}
                />
              </div>
              <div className="form-group">
                <label htmlFor="amount">비용</label>
                <input
                  type="number"
                  className="form-control"
                  id="amount"
                  name="amount"
                  placeholder="예) 100"
                  value={this.state.amount}
                  onChange={(e) => this.setState({ amount: e.target.value })}
                />
              </div>
            </div>
            <button type="submit" className="btn" onClick={this.handleSubmit}>
              제출
            </button>
          </form>
        </div>
        <div className="expenseList">
          {this.state.expenseData.map((data) => (
            <li className="item" key={data.id}>
              <div className="info">
                <span className="expense">{data.title}</span>
                <span className="amount"> {data.amount} 원</span>
              </div>
              <div className="buttons">
                <button
                  className="edit-btn"
                  onClick={() => this.handleEdit(data.id, data.title, data.amount)}
                >
                  수정
                </button>
                <button
                  className="clear-btn"
                  onClick={() => this.handleRemove(data.id)}
                >
                  삭제
                </button>
              </div>
            </li>
          ))}
        </div>
        <div style={{ display: "flex", justifyContent: "end", marginTop: "0rem" }}>
          <p style={{ fontSize: "2rem" }}>
            총지출: 
            <span>{this.getTotalExpense()}원</span>
          </p>
        </div>
      </div>
    );
  }
}