import React, {useState} from "react";
import PropTypes from 'prop-types';

const SaludoFunction = (props) => {

    const [age, setAge] = useState(25)
    const incrementAge = () => {
        setAge(age + 1)
    }

    return(
        <div>
            <h3>Componente tipo Function</h3>
            <h2>Hola: {props.name}</h2>
            <h2>Tu edad es: {age}</h2>
            <div>
                <button onClick={incrementAge}>Sumar Edad</button>
            </div>
        </div>
    )
}

SaludoFunction.propTypes = {
    name: PropTypes.string
}

export default SaludoFunction;