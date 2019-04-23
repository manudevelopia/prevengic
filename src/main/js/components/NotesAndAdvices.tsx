import * as React from "react";
import {Button, Col, Row, Table} from "reactstrap";


export class NotesAndAdvices extends React.Component<any, any> {

  constructor(props: any) {
    super(props);
  }

  private addToSelected(index: number) {
    this.props.onChange(index);
  }

  public render() {
    let compounds = this.props.notes.map((compound: any, index: number) => {
        return <tr key={index}>
          <th scope="row">{index + 1}</th>
          <td>{compound.name}</td>
          <td>{compound.fh}</td>
          <td>{compound.notes}</td>
        </tr>;
      }
    );

    return (
      <Row>
        <Col md={12}>
          <h4>Frases H y Notas</h4>
          <Table>
            <thead>
            <tr>
              <th>#</th>
              <th>Nombre</th>
              <th>FH</th>
              <th>Notes</th>
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