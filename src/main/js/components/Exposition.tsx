import * as React from "react";
import {Col, Row, Table} from "reactstrap";


export class Exposition extends React.Component<any, any> {

  constructor(props: any) {
    super(props);
  }


  public render() {
    let compounds = this.props.calculations.map((compound: any, index: number) => {
        return <tr key={index}>
          <th scope="row">{index + 1}</th>
          <td>{compound.name}</td>
          <td>{compound.exposition.ed}</td>
          <td>{compound.exposition.vlaEd}</td>
          <td>{compound.exposition.i}</td>
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