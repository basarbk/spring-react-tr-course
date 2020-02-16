import React from 'react';

const Input = props => {
  const { label, error, name, onChange, type } = props;
  const className = error ? 'form-control is-invalid' : 'form-control';
  return (
    <div className="form-group">
      <label>{label}</label>
      <input className={className} name={name} onChange={onChange} type={type} />
      <div className="invalid-feedback">{props.error}</div>
    </div>
  );
};

export default Input;
