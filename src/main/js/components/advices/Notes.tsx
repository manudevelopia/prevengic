import * as React from "react";
import {Col, Row, Table} from "reactstrap";


export class Notes extends React.Component<any, any> {

  constructor(props: any) {
    super(props);
  }

  public render() {
    let notes = this.props.notes.map((note: any, index: number) => {
        return <tr key={index}>
          <th scope="row">{index + 1}</th>
          <td>{note.code}</td>
          <td>{note.description}</td>
        </tr>;
      }
    );

    return (
      <Row>
        <Col md={12}>
          <h4>Notas</h4>
          <Table>
            <thead>
            <tr>
              <th>#</th>
              <th>Código</th>
              <th>Descripción</th>
            </tr>
            </thead>
            <tbody>{notes}</tbody>
          </Table>
        </Col>
      </Row>
    );
  }

}