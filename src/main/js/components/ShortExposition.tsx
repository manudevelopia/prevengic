import * as React from "react";
import {Col, Row, Table} from "reactstrap";


export class ShortExposition extends React.Component<any, any> {

  constructor(props: any) {
    super(props);
  }


  public render() {
    let compounds = this.props.calculations.map((compound: any, index: number) => {
        return <tr key={index}>
          <th scope="row">{index + 1}</th>
          <td>{compound.name}</td>
          <td>{compound.shortExposition.ed}</td>
          <td>{compound.shortExposition.vlaEd}</td>
          <td>{compound.shortExposition.i}</td>
        </tr>;
      }
    );

    return (
      <Row>
        <Col md={12}>
          <h4>Resultados Exposición corta</h4>
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