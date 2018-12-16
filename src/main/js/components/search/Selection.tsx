import * as React from "react";
import {Button, Col, Form, Input, Row, Table} from "reactstrap";


export class Selection extends React.Component<any, any> {

  constructor(props: any) {
    super(props);
  }

  public render() {
    let compounds = this.props.results.map((compound: any, index: number) => {
        return <tr key={index}>
          <th scope="row">{index + 1}</th>
          <td>{compound.cas}</td>
          <td>{compound.name}</td>
          <td>
            <Input type="text" name="concentration" id="concentration" placeholder="Concentración"/>
          </td>
          <td>
            <Input type="text" name="exposition" id="exposition" placeholder="Exposición"/>
          </td>
          <td><Button color="danger" size="sm">Eliminar</Button></td>
        </tr>;
      }
    );

    return (
      <Row>
        <Col md={12}>
          <h4>Compuestos</h4>
          <Form>
            <Table>
              <thead>
              <tr>
                <th>#</th>
                <th>CAS</th>
                <th>Nombre</th>
                <th>Concetración</th>
                <th>Tiempo</th>
                <th/>
              </tr>
              </thead>
              <tbody>{compounds}</tbody>
            </Table>
            <Button color="success">Generar informe</Button>
          </Form>
        </Col>
      </Row>
    );
  }

}