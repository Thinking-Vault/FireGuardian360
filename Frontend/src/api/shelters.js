export async function fetchShelters(lat, lng, radius = 0.1) {
    const res = await fetch(`/shelters/nearby?lat=${lat}&lng=${lng}&radius=${radius}`);
    return await res.json();
}

export async function postShelter(shelter) {
    const res = await fetch('/shelters', {method:'POST',headers:{'Content-Type':'application/json'},body:JSON.stringify(shelter)});
    return await res.json();
}