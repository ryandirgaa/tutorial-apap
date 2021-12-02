import React from "react";
import Button from "../Button";
import classes from "./styles.module.css";

const Item = (props) => {
    const { id, title, price, description, category, quantity, handleEdit, handleDelete, handleSubmitToCart} = props;
    return (
        <div className={classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Harga: ${price}`}</p>
            <p>{`Deskripsi: ${description}`}</p>
            <p>{`Kategori: ${category}`}</p>
            <p>{`stok: ${quantity}`}</p>

            <Button action={handleEdit}>Edit</Button>
            <Button action={handleDelete}>Delete</Button>
            <br></br>
            <form>
                <input type="number"/> 

                <Button action={handleSubmitToCart}>Add to cart</Button>
            </form>
            
        </div>
    );
};

export default Item;
