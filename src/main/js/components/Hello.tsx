import * as React from "react";
import {Alert} from "reactstrap";

export interface HelloProps {
    compiler: string;
    framework: string;
}

// 'HelloProps' describes the shape of props.
// State is never set so we use the '{}' type.
export class Hello extends React.Component<HelloProps, {}> {

    render() {
        return <div>
            <Alert color="primary">
                This is a primary alert — check it out!
            </Alert>

            <h1>Hello from {this.props.compiler} and {this.props.framework}!</h1>
        </div>
    }

}