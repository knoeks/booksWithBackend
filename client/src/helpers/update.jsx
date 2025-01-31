import axios from "axios";
const url = "http://localhost:5000/api/books";

export const updateOne = async (id, data) => {
  const response = await axios.patch(url + "/" + id, data);
  return response.data;
}