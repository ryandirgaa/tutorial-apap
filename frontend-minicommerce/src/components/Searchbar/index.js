import React from "react";

const SearchBar = (props) => {
    const barStyling = {width: "100%", border: "1px solid black", padding: "8px"};
    return (
        <input
            style={barStyling}
            type="search"
            placeholder={"Cari items"}
            onChange={props.handleChange}
        />
    );
}

export default SearchBar;