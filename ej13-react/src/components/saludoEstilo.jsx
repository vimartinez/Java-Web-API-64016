import React,{useState} from "react";

const estilo1 = {
    color: 'chocolate',
    fontStyle: 'italic',
    padding: 10
}

const estilo2 = {
    color: 'grey',
    fontWeight: 'bold',
    padding: 10
}

const SaludoEstilo = (props) => {

    const [usaEstilo1, setUsaEstilo] = useState(true)
    const cambiarEstilo = () => {
        setUsaEstilo(!usaEstilo1)
    }
    
    return(
        <div>
            <div style={estilo1}> Texto con estilo 1</div>
            <div style={estilo2}> Texto con estilo 2</div>
            <div style={ usaEstilo1 ? estilo1 : estilo2}> 
            {
                usaEstilo1 ?
                (<p> Este texto está usando el estilo 1</p>)
                :
                (<p> Este texto está usando el estilo 2</p>)
            }
            </div>
            <button onClick={cambiarEstilo}>{usaEstilo1 ? 'Cambiar a estilo 2':'Cambiar a estilo 1'}</button>
        </div>
    )
}

export default SaludoEstilo;