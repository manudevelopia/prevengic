import * as React from "react";
import {shallow, mount} from "enzyme";

import Hello from "../../../main/js/Hello";

it("renders the heading", () => {
    const result = shallow(<Hello/>).contains(<h1>Hello!</h1>);
    expect(result).toBeTruthy();
});

describe("Hello world test from ezyme", () =>{
    test("render", () => {
        const wrapper = shallow(<h1/>);
        expect(wrapper.exists()).toBe(true);
    })
});