import React, { Component } from "react";
import Item from "../../components/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/Button";
import Modal from "../../components/Modal";
import SearchBar from "../../components/Searchbar";


class ItemList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [],
            isLoading: false,
            isCreate: false,
            isEdit: false,
            id: "",
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0
        };
        
        this.loadData = this.loadData.bind(this);
        this.handleClickLoading = this.handleClickLoading.bind(this);
        this.handleAddItem = this.handleAddItem.bind(this);
        this.handleEditItem = this.handleEditItem.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.handleSubmitItem = this.handleSubmitItem.bind(this);
        this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleDeleteItem = this.handleDeleteItem.bind(this);
        this.findItem = this.findItem.bind(this);
    }

    componentDidMount() {
        this.loadData();
    }

    async loadData() {
        try {
            const { data } = await APIConfig.get("/item");
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
    
    handleAddItem() {
        this.setState({ isCreate:true });
    }

    handleCancel(event) {
        event.preventDefault();
        this.setState({ isCreate: false, isEdit: false });
    }

    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }

    handleEditItem(item) {
        this.setState({
            isEdit: true,
            id: item.id,
            title: item.title,
            price: item.price,
            description: item.description,
            category: item.category,
            quantity: item.quantity
        })
    }

    async handleSubmitItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.post("/item", data);
            this.setState({
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } 
        catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }
        
    async handleSubmitEditItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.put(`/item/${this.state.id}`, data);
            this.setState({
                id: "",
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } 
        catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    async handleDeleteItem(id) {
        try {
            await APIConfig.delete(`/item/${id}`);
            this.loadData();
        } 
        catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async findItem(text){
        if(text === "") this.loadData();
        else{
            const filtered = this.state.items.filter(items => {
                return items.title.toLowerCase().includes(text.toLowerCase())
            })
            this.setState({input: text});
            this.setState({items: filtered});
        }
    }
    

    render() {
        return (
            <div className={classes.itemList}>
                <h1 className={classes.title}>All Items</h1>
                <SearchBar handleChange={(e) => this.findItem(e.target.value)}/>
                <br></br><br></br>
                <Button action={this.handleAddItem}>Add Item</Button>
                <div>
                    {this.state.items.map((item) => (
                        <Item
                            key={item.id}
                            id={item.id}
                            title={item.title}
                            price={item.price}
                            description={item.description}
                            category={item.category}
                            quantity={item.quantity}
                            handleEdit = {() => (this.handleEditItem(item))}
                            handleDelete={() => this.handleDeleteItem(item.id)}
                        />
                    ))}
                </div>
                <Modal 
                show={this.state.isCreate || this.state.isEdit}
                handleCloseModal={this.handleCancel}
                modalTitle={this.state.isCreate 
                ? "Add Item" 
                : `Edit Item ID ${this.state.id}`}>
                    <form>
                        <input 
                        className={classes.textField}
                        type="text"
                        placeholder="Nama Item"
                        name="title"
                        value={this.state.title}
                        onChange={this.handleChangeField}/>

                        <input 
                        className={classes.textField}
                        type="number"
                        placeholder="Harga"
                        name="price"
                        value={this.state.price}
                        onChange={this.handleChangeField}/>

                        <textarea 
                        className={classes.textField}
                        placeholder="Deskripsi"
                        name="description"
                        rows="4"
                        value={this.state.description}
                        onChange={this.handleChangeField}/>

                        <input 
                        className={classes.textField}
                        type="text"
                        placeholder="Kategori"
                        name="category"
                        value={this.state.category}
                        onChange={this.handleChangeField}/>

                        <input 
                        className={classes.textField}
                        type="number"
                        placeholder="Qty"
                        name="quantity"
                        value={this.state.quantity}
                        onChange={this.handleChangeField}/>

                        <Button
                            action={
                                this.state.isCreate
                                    ? this.handleSubmitItem
                                    : this.handleSubmitEditItem
                            }
                            variant="primary">
                            {this.state.isCreate ? "Create" : "Edit"}
                        </Button>
                       <Button action={this.handleCancel}>Cancel</Button>
                    </form>
                </Modal>
            </div>
        );
    }
}

export default ItemList;