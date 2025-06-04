export async function fetchChecklist(userId) {
    const res = await fetch(`/checklist/user/${userId}`);
    return await res.json();
}
export async function createChecklist(item) {
    const res = await fetch('/checklist', {method:'POST',headers:{'Content-Type':'application/json'},body:JSON.stringify(item)});
    return await res.json();
}
export async function updateChecklist(item) {
    const res = await fetch('/checklist', {method:'PUT',headers:{'Content-Type':'application/json'},body:JSON.stringify(item)});
    return await res.json();
}
export async function deleteChecklist(itemId) {
    await fetch(`/checklist/${itemId}`, {method:'DELETE'});
}