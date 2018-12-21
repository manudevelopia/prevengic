import * as React from "react";
import {shallow} from "enzyme";

import Hello from "../../../main/js/Hello";
import {Header} from "../../../main/js/components/search/Header";
import {Search} from "../../../main/js/components/search/Search";
import {Selection} from "../../../main/js/components/search/Selection";

it("renders the heading", () => {
    const result = shallow(<Hello/>).contains(<h1>Hello!</h1>);
    expect(result).toBeTruthy();
});

describe("Layout contains a ....", () => {

    test("Header", () => {
        const wrapper = shallow(<Header/>);
        expect(wrapper.contains(<h1>Prevengic</h1>)).toBeTruthy();
    });

    test("Search", () => {
        const wrapper = shallow(<Search/>);
        expect(wrapper.contains(<h4>Buscador</h4>)).toBeTruthy();
    });

    test("Selection", () => {
        const wrapper = shallow(<Selection/>);
        expect(wrapper.exists()).toBeTruthy();
    });

});