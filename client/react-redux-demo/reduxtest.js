const redux = require('redux');
const createStore = redux.createStore;


const initialState = {
    employees: [
        { id: 101, name: 'Abhinav', salary: 12345 },
        { id: 102, name: 'Abhishek', salary: 23456 },
        { id: 103, name: 'Ajay', salary: 34567 }
    ]
}

// Reducer
const store = createStore((state = initialState,  action)=>{
    switch(action.type){
        case 'ADD_EMPLOYEE':
            let newEmployees = [...state.employees, action.payload]
            // newEmployees.push(action.payload)
            return {
                employees: newEmployees
            }

        case 'FETCH_EMPLOYEES':
            return {
                employees: state.employees
            }
    }
    return state;

})

//Subscribe
store.subscribe(()=> console.log('Action fired', store.getState()));


// console.log(store.getState())
// Action Dispatch
store.dispatch({type: 'FETCH_EMPLOYEES'})
store.dispatch({type: 'ADD_EMPLOYEE', payload: {id:1, name:'Ravi', salary: 23444}})



// console.log(store.getState())
// Get State
