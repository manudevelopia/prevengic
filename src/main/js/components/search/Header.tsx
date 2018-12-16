import * as React from "react";
import {Row} from "reactstrap";


export class Header extends React.Component<any, any> {

  constructor(props: any) {
    super(props);
  }

  public render() {
    return (
      <Row>
        <h1>Prevengic</h1>
      </Row>
    );
  }

}