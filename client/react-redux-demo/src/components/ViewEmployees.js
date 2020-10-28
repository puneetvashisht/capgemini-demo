import React, { Component } from 'react';
import { connect } from 'react-redux';
import * as actions from '../actions/action'

class ViewEmployees extends Component {
    constructor(props) {
        super(props)
        // this.state = {
        //     employees: [
        //         { id: 101, name: 'Abhinav', salary: 12345 },
        //         { id: 102, name: 'Abhishek', salary: 23456 },
        //         { id: 103, name: 'Ajay', salary: 34567 }
        //     ]
        // }
    }


    componentDidMount() {
        console.log('once...')
        this.props.onFetchEmployees();
    }




    render() {
        var employeeList = this.props.employees && this.props.employees.map(function (employee, i) {
            console.log(employee);
            return (
                <tr key={i}>
                    <th scope="row">{i + 1}</th>
                    <td>{employee.id}</td>
                    <td>{employee.name}</td>
                    <td>{employee.salary}</td>
                </tr>
            );
        })




        return (

            <table className="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Salary</th>
                    </tr>
                </thead>
                <tbody>

                    {employeeList}
                </tbody>
            </table>


        );
    }
}

const mapStateToProps = (state) => {
    return {
        message: state.message,
        employees: state.employees
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        onFetchEmployees: () => dispatch(actions.fetchEmployees())
    }
}

// export default ViewEmployees;
export default connect(mapStateToProps, mapDispatchToProps)(ViewEmployees);