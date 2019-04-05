import * as React from "react";
import {Button, Col, Row, Table} from "reactstrap";


export class Results extends React.Component<any, any> {

  constructor(props: any) {
    super(props);
  }

  private addToSelected(index: number) {
    this.props.onChange(index);
  }

  public render() {
    let compounds = this.props.results.map((compound: any, index: number) => {
        return <tr key={index}>
          <th scope="row">{index + 1}</th>
          <td>{compound.nce}</td>
          <td>{compound.cas}</td>
          <td>{compound.name}</td>
          <td><Button color="primary" size="sm" onClick={() => {this.addToSelected(index)}}>Añadir</Button></td>
        </tr>;
      }
    );

    return (
      <Row>
        <Col md={12}>
          <h4>Resultados</h4>
          <Table>
            <thead>
            <tr>
              <th>#</th>
              <th>Nº CE</th>
              <th>CAS</th>
              <th>Nombre</th>
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