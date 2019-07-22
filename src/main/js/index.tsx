import * as React from "react";
import * as ReactDOM from "react-dom";

import 'bootstrap/dist/css/bootstrap.min.css';

import {Layout} from "./components/Layout";

ReactDOM.render(
    <Layout compiler="TypeScript" framework="React"/>,
    document.getElementById("layout")
);