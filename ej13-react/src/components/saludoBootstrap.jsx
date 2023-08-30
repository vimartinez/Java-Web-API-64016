import React,{useState} from "react";
import 'bootstrap/dist/css/bootstrap.css'

const SaludoBootstrap = (props) => {
    return(
        <div>
            <div className="alert alert-primary" role="alert">  Estilo Alert!</div>
            <div className="alert alert-secondary" role="alert">  Texto secondary</div>
            <div className="alert alert-success" role="alert">  A simple success alert—check it out!</div>
            <div className="alert alert-danger" role="alert">  A simple danger alert—check it out!</div>
        </div>
    )
}

export default SaludoBootstrap;