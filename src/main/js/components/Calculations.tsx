import * as React from "react";
import {Button, Col, Row, Table} from "reactstrap";


export class Calculations extends React.Component<any, any> {

  constructor(props: any) {
    super(props);
  }

  private addToSelected(index: number) {
    this.props.onChange(index);
  }

  public render() {
    let compounds = this.props.calculations.map((compound: any, index: number) => {
        return <tr key={index}>
          <th scope="row">{index + 1}</th>
          <td>{compound.name}</td>
          <td>{compound.ed}</td>
          <td>{compound.vlaed}</td>
          <td>{compound.i}</td>
        </tr>;
      }
    );

    return (
      <Row>
        <Col md={12}>
          <h4>Resultado del cálculo</h4>
          <Table>
            <thead>
            <tr>
              <th>#</th>
              <th>Nombre</th>
              <th>ED</th>
              <th>VLA - ED</th>
              <th>I</th>
              <th/>
            </tr>
            </thead>
            <tbody>{compounds}</tbody>
          </Table>
        </Col>
      </Row>
    );
  }

}