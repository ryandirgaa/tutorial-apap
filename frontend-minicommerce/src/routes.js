import React from "react";
import { Route, Switch } from "react-router-dom";
import Item from "containers/itemlist";
import Cart from "containers/cartlist";

export const AppRoutes = () => {
    return (
        <div>
            <Switch>
                <Route exact path="/" component={Item}/>
                <Route exact path="/cart" component={Cart}/>
            </Switch>
        </div>
    )
}