import React from "react";

function Contact() {
    return <div>
        <div className="card" >
            <div className="card-body">
                <h5 className="card-title">Java Web API</h5>
                <h6 className="card-subtitle mb-2 text-body-secondary">Contactate con nosotros</h6>
                <p className="card-text">
                <div className="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Email address</label>
                    <input type="email" className="form-control" id="exampleFormControlInput1" placeholder="name@example.com" />
                    </div>
                    <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">Example textarea</label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                    </div>
                </p>
            </div>
        </div>
    </div>
}

export default Contact;