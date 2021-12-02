import React, { Component } from "react";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";

class CartList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            carts: [],
            isLoading: false,
            id: "",
            quantity: 0,
            idItem: ""
        };
    }

    componentDidMount() {
        this.loadData();
    }

    async loadData() {
        try {
            const { data } = await APIConfig.get("/cart");
            this.setState({ items: data.result });
        } 
        catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }
        
    handleClickLoading() {
        const currentLoading = this.state.isLoading;
        this.setState({ isLoading: !currentLoading });
        console.log(this.state.isLoading);
    } 

    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }



    render() {
        return (
            <div className={classes.itemList}>
                <h1 className={classes.title}>Cart Items</h1>
                <div style={{ position: "fixed", top: 25, right: 25 }}>
                </div>
            </div>
        );
    }
}

export default CartList;