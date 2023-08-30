import React from "react";
import { Component } from "react";
import PropTypes from 'prop-types';
import { render } from "@testing-library/react";

class SaludoClass extends Component {

    constructor(props){
        super(props);
        this.state = {
            age : 35
        }
    }

render(){
    return (
        <div>
            <h2>Java Web API - React</h2>
            <h3>Componte de tipo Clase</h3>
            <h4>Hola: {this.props.name}</h4>
            <h4>Tu edad es: {this.state.age}</h4>
            <div>
                <button onClick={this.incrementAge}>Sumar edad</button>
            </div>
        </div>
        )
    }

    incrementAge = () => (
        this.setState((prevState) => (
            {
                age: prevState.age + 1
            }
        ))
    )

}

SaludoClass.propTypes = {
    name: PropTypes.string
}

export default SaludoClass;