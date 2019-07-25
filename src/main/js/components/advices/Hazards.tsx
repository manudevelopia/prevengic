import * as React from "react";
import {Col, Row, Table} from "reactstrap";

export class Hazards extends React.Component<any, any> {

  constructor(props: any) {
    super(props);
  }

  public render() {
    let hazards = this.props.hazards.map((hazard: any, index: number) => {
        return <tr key={index}>
          <th scope="row">{index + 1}</th>
          <td>{hazard.code}</td>
          <td>{hazard.description}</td>
        </tr>;
      }
    );

    return (
      <Row>
        <Col md={12}>
          <h4>Frases H</h4>
          <Table>
            <thead>
            <tr>
              <th>#</th>
              <th>Código</th>
              <th>Descripción</th>
            </tr>
            </thead>
            <tbody>{hazards}</tbody>
          </Table>
        </Col>
      </Row>
    );
  }

}